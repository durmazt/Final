import React from 'react';
import { Link } from 'react-router-dom';
import CartSummary from './CartSummary';
import { Typography, List, ListItem, ListItemText, Button, Box, Card, Divider} from '@mui/material';
import { useState, useEffect,useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import { AlignHorizontalCenter } from '@mui/icons-material';
import { useAuth } from '../context/AuthContext';
const CartDetail = () => {

 
  
  const {getUser} = useAuth(); 
  const user = getUser();
  console.log(user);
  
  const [cart, setCart] = useState([]);
  const [cartTotalPrice,setCartTotalPrice]=useState(0);
  const navigate=useNavigate();

  
  const urlList = `http://localhost:8080/cart/get/${user.data.id}` ;

  useEffect(() => {
    if (urlList) {
      const fetchData = async () => {
        const response = await fetch(urlList);
        if (response.ok) {
          const data = await response.json();
          console.log(data);
          setCart(data);
          calcTotalPrice(data);
          
          console.log(user);
        } else {
          setCart([]);
        }
      };
  
      fetchData();
    }
  }, [urlList]);
  const deleteProduct = (productId) => {
    const updatedCart = [...cart];
    updatedCart.forEach((carti) => {
      if (carti.productId.productId === productId) {
        const index = updatedCart.indexOf(carti);
        if (carti.salesQuantity < 2) {
          updatedCart.splice(index, 1);
        } else {
          carti.salesQuantity = carti.salesQuantity - 1;
        }
        console.log(
          "index product id: " +
            carti.productId.productId +
            " product id: " +
            productId +
            "product name: " +
            carti.productId.productName
        );
      }
    });
    setCart(updatedCart);
  };
  const removeToCart = (productId) => {
    
    fetch(`http://localhost:8080/cart/remove/${user.data.id}/${productId}`, {
      method: 'POST'
    })
      .then(response => {
        if (!response.ok) {
         
          throw new Error('Failed to remove product to cart');
          
        }
        deleteProduct(productId);
        calcTotalPrice(cart);
        console.log('Product removed to cart successfully');
      })
      .catch(error => {
        console.error(error);
      });
      
   
  };

  const checkoutNavigate=(cartId)=>
  {
    if(cart.length != 0)
    navigate(`/cart/checkout/${cartId}}`)
    else
    alert("no more products, prechious")
  } 
  

  const  calcTotalPrice= (data)=>
  {
    let prices=0;
    data.map((cart)=>
    prices=(cart.productId.salesPrice)*cart.salesQuantity +prices

    );
    setCartTotalPrice(prices);
  }



  return (
    <>
    <Box>
      <Card sx={{ marginTop: 10, marginBottom: 2 }}>
      <CartSummary cartProductsLength={cart.length} cartTotalPrice={cartTotalPrice} />
      <Link to="/cart/checkout" style={{ textDecoration: 'none' }} >
        <Button variant="contained" color="primary" sx={{marginBottom:2}} onClick={checkoutNavigate}>
          Go to Checkout
        </Button>
      </Link>
      </Card>
      <List >
        {cart.map((cart) => (

          <Card key={cart.productId.productId} sx={{ marginTop: 2, marginBottom: 2,}}>
          <ListItem key={cart.productId.productId}  sx={{justifyContent:'space-between', alignItems:'center'}} >
          <List >
            <img src={cart.productId.imageUrl} alt={cart.productId.productName} width="200" height="200" />
            
            <ListItemText   
              primary={<Typography  sx={{ alignContent:'center',fontSize:20}} >
              {cart.productId.productName}
             </Typography>}
            />
            
            <Typography  sx={{fontWeight:"bold", alignContent:'center',fontSize:20}} >
             {cart.salesQuantity} adet
            </Typography>
            </List>
            <Typography  sx={{fontWeight:"bold", alignContent:'center',fontSize:25}} >
              {cart.productId.salesPrice}$
            </Typography>
            <Button
              variant="contained"
              color="secondary"
              onClick={() => removeToCart( cart.productId.productId)}
            >
              Remove
            </Button>
          </ListItem>
          </Card>
        ))}
      </List>
      
    </Box>
    </>
  );
};

export default CartDetail;