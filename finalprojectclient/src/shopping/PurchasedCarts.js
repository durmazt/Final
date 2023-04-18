import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { createTheme } from '@material-ui/core';
import {
  Box,
  Card,
  CardContent,
  Grid,
  Typography,
  Button,
  ThemeProvider,
} from '@mui/material';

const PurchasedCart = () => {
  const [cartItems, setCartItems] = useState([]);


    const { getUser } = useAuth();
    const user = getUser();
    const userId=user.data.id;

  useEffect(() => {
    const fetchCartItems = async () => {
      const response = await fetch(`http://localhost:8080/cart/purchased/${userId}`);
      const data = await response.json();
      setCartItems(data);
      console.log(data)
    };
    fetchCartItems();
  }, [userId]);

  // group cart items by cartId
  const cartGroups = cartItems.reduce((groups, item) => {
    const groupKey = item.cartId.cartId;
    if (!groups[groupKey]) {
      groups[groupKey] = {
        key: groupKey,
        items: [],
      };
    }
    groups[groupKey].items.push(item);
    return groups;
  }, {});
  const theme = createTheme({
    palette: {
      background: {
        paper: '#EFF7FF', 
      },
    },
  });
  const theme1 = createTheme({
    palette: {
      background: {
        paper: '#f5f5f5', 
      },
    },
  });


  return (
    <Grid container spacing={2} marginTop={5}>
      {Object.values(cartGroups).map((group) => (
        <Grid item xs={12} md={6} lg={4} key={group.key}>
        <ThemeProvider theme={theme}>
          <Card >
            <CardContent>
              <Typography variant="h5" component="h2">
                Cart {group.key}
              </Typography>
              <Grid container spacing={2}>
                {group.items.map((item) => (
                  <Grid item xs={12} md={6} key={item.cartProductId}>
                    <ThemeProvider theme={theme1}>
                    <Card>
                      <CardContent>
                        <img src={item.productId.imageUrl} alt={item.productId.productName} width="100%" />
                        <Typography gutterBottom variant="h6" component="h3">
                          {item.productId.productName}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                          {item.salesQuantity} adet
                        </Typography>
                        <Typography variant="body1" color="text.secondary">
                          {item.productId.salesPrice}$
                        </Typography>
                       
                      </CardContent>
                    </Card>
                    </ThemeProvider>
                  </Grid>
                ))}
              </Grid>
            </CardContent>
          </Card>
          </ThemeProvider>
        </Grid>
      ))}
    </Grid>
  );
};

export default PurchasedCart;