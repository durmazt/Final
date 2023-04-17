import { Button,Card, CardContent, IconButton, Typography } from '@mui/material';
import AddShoppingCartIcon from '@material-ui/icons/AddShoppingCart';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { AlignHorizontalCenter } from '@mui/icons-material';
import {useAuth} from '../context/AuthContext';
import {useNavigate} from 'react-router-dom';
export default function ProductComponent({product}){
//when the user clicks on the add to cart button, we need to add the product to the cart http://localhost:8080/cart/add/categoryId/productId wrtie a function to handle this
//put here: http://localhost:8080/cart/add/categoryId/productId with http method PUT
//delete here: http://localhost:8080/cart/Remove/categoryId/productId with http method DELETE
const auth=useAuth();
const { getUser, userIsAuthenticated, userLogin, userLogout } = auth;
const user = getUser(); 
const urlList = "http://localhost:8080/product/";
const navigate=useNavigate();
// if cart is completed, then we will send new id to the backend
const [cart, setCart] = useState([]);
  useEffect(() => {
    fetch(urlList)
      .then(data => data.json())
      .then(cart => {
      
        setCart(cart)
      })
  }, [urlList]);

  const addToCart = (userId, productId) => {
    if(userIsAuthenticated()){
    fetch(`http://localhost:8080/cart/add/${userId}/${productId}`, {
      method: 'POST'
    })
      .then(response => {
        if (!response.ok) {
         
          throw new Error('Failed to add product to cart');
        }
       
        console.log('Product added to cart successfully');
      })
      .catch(error => {
        console.error(error);
      });
    }
    else{

      
      navigate('/login');

    }
      
   
  };
    return (
        <Card sx={{ maxWidth: 450 }}>
          <CardContent>
          
            <img src={product.imageUrl} maxWidth={600} height={300}  alt={product.productName} />
            
            <Typography gutterBottom variant="h5" component="div">
              {product.productName}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              Sales Price: ${product.salesPrice}
            </Typography>
            <Button
                variant="contained"
                color="primary"
                startIcon={<AddShoppingCartIcon />}
                onClick={() => addToCart(user.data.id, product.productId)}
              >
            Add to Cart
            </Button>
            
          </CardContent>
        </Card>
      );

}
        
