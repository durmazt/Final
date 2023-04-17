import React from 'react';
import { Typography, Box, Card, Divider } from '@mui/material';

const CartSummary = ({ cartProductsLength,cartTotalPrice }) => {
  return (
    <Box sx={{ marginTop: 2, marginBottom: 2 }}>
      <Typography variant="h5" gutterBottom sx={{fontWeight:'bold'}}>
        Cart Summary
      </Typography>
      <Typography variant="h6" sx={{fontWeight:'bold'}}>
        Items in cart: {cartProductsLength}
      </Typography>
      <Typography variant="h6"sx={{fontWeight:'bold'}}>Total: {cartTotalPrice.toFixed(2)}$</Typography>
      
    </Box>
  );
};

export default CartSummary;