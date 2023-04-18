import React from "react";
import { List,ListItem,ListItemButton,ListItemText } from '@mui/material';
import { useNavigate } from "react-router-dom";
export default function CartCatalogs() {
    const cartAccouunt=["Hesap","Sepet","Siparişler"]
    const navigate=useNavigate();
    const navigateToOthers=(data)=>{
      console.log("whayda "+ data);
        if(data==="Hesap")
        {
            navigate("/account");
        }
        else if(data==="Sepet")
        {
            navigate('/cart/get');
        }
        else if(data==="Siparişler")
        {
            navigate('/cart/purchased');
        }
    }
  return (
    <List>
    {cartAccouunt.map((data) => (
      <ListItem key={data} disablePadding>
        <ListItemButton  onClick={()=>navigateToOthers(data)}>
          <ListItemText primary={data} />
        </ListItemButton>
      </ListItem>
    ))}
  </List> 
  );
}