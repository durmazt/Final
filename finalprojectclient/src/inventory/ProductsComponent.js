import React from 'react';
import { Grid } from '@mui/material';
import ProductComponent from './ProductComponent';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Margin } from '@mui/icons-material';
function ProductsComponent() {
  
  const { categoryId } = useParams();
  const urlList = "http://localhost:8080/products/" + categoryId;
  const [products, setProducts] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch(urlList);
      if (response.ok) {
        const products = await response.json();
        console.log(products);
        setProducts(products);
      } else {
        setProducts([]);
      }
    };
  
    fetchData();
  }, [urlList]);

  
  return (
    <>
    {products.length === 0  ? <h1>No Products in this category</h1> :
    <Grid container spacing={3} marginTop={6} justifyContent="center" justifyItems="center" justifySelf="center">
        {products.map((product) => (
          <Grid item xs={0} md={4} key={product.productId} justifyContent="center" justifyItems="center" justifySelf="center">
            <ProductComponent  product={product} />
          </Grid>
        ))}
      </Grid>
     }
    
    </>
  );

}

export default ProductsComponent;
