import React, { useState } from 'react';
import {
  Button,
  Box,
  TextField,
  Typography,
  Container,
} from '@mui/material';
import { useParams } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';


const CartCheckout = () => {
  const [cardNumber, setCardNumber] = useState('');
  const { getUser } = useAuth();

  const user = getUser();
  const navigate=useNavigate();

  

 
  
  
  

  const handleSubmit = (e) => {
  
    e.preventDefault();
    const url = 'http://localhost:8080/cart/checkout/'+user.data.id; 
  
  
    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(cardNumber),
    })
      .then((response) => response.json())
      .then((result) => {
        
        // handle success
        navigate('/');
        console.log(result);
      })
      .catch((error) => {
        // handle error
        console.error(error);
      });
  };
 
  return (
    <Container>
      <Typography variant="h4" gutterBottom>
        Cart Checkout
      </Typography>
      <form onSubmit={handleSubmit}>
        
        <Box sx={{ marginBottom: 2 }}>
          <TextField
            label="Card Number"
            variant="outlined"
            fullWidth
            value={cardNumber}
            onChange={(e) => setCardNumber(e.target.value)}
          />
        </Box>
        <Button variant="contained" color="primary" type="submit">
          Checkout
        </Button>
      </form>
    </Container>
  );
};

export default CartCheckout;