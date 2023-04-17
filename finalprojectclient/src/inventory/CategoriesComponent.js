import React from 'react';
import { Alert, Card, CardContent, Typography } from '@mui/material';
import { BorderAllOutlined } from '@material-ui/icons';

import { useState, useEffect } from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import { useNavigate } from 'react-router-dom';

function CategoriesComponent() {
  
  const urlList = "http://localhost:8080/categories";
  const [categories, setCategories] = useState([]);
  useEffect(() => {
    fetch(urlList)
      .then(data => data.json())
      .then(categories => {
        console.log(categories);
        setCategories(categories)
      })
  }, [urlList]);

  const navigate = useNavigate();
  const handleClick = (categoryId) => () => {
    navigate(`/products/${categoryId}`);
  }



  return (

    <List>
    {categories.map((category) => (
      <ListItem key={category.categoryId} disablePadding>
        <ListItemButton onClick={handleClick(category.categoryId)} >
          <ListItemText primary={category.categoryName} />
          
        </ListItemButton>
      </ListItem>
    ))}
  </List>
  );
}
/*
    //card sx size is conntent size
    <Grid item xs={12} sm={3}>
    <Card sx={{width:"120px", display:"flex", backgroundColor:"bisque" }}>
      <CardContent>
        <Typography variant="h6" gutterBottom>
          Categories
        </Typography>
        {categories.map((category) => (
          <Typography key={category.categoryId} variant="body2" gutterBottom sx={{ cursor: 'pointer' }} onClick={() => handleClic(category.categoryId) } style={{ fontWeight: selectedCategoryId === category.categoryId ? 'bold' : 'normal' }}>
            {category.categoryName}
          </Typography>
        ))}
      </CardContent>
    </Card>
    </Grid>
 */
export default CategoriesComponent;