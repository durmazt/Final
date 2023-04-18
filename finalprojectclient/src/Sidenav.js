import * as React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Divider from '@mui/material/Divider';
import Drawer from '@mui/material/Drawer';
import IconButton from '@mui/material/IconButton';
import { CenterFocusStrong, ShoppingCart } from '@mui/icons-material';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import { LocalMall } from '@mui/icons-material';
import MenuIcon from '@mui/icons-material/Menu';
import Toolbar from '@mui/material/Toolbar';
import LoginIcon from '@mui/icons-material/Login';
import LogoutIcon from '@mui/icons-material/Logout';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import CategoriesComponent from './inventory/CategoriesComponent';
import ProductsComponent from './inventory/ProductsComponent';
import { Routes, Route, Link, useNavigate } from 'react-router-dom';
import {useState} from 'react';
import { Button } from '@mui/material';
import CartDetail from './shopping/CartDetail';

import { List,ListItem,ListItemButton,ListItemText } from '@mui/material';
import Welcome from './Welcome';
import Login from './authantication/Login';
import Signup from './authantication/Signup';
import { useAuth } from './context/AuthContext';
import CartCheckout from './shopping/CartCheckout';
import PurchasedCart from './shopping/PurchasedCarts';
import CartCatalogs from './shopping/CartCatalogs';
import Account from './shopping/Account';


function ResponsiveDrawer(props) {
  const [drawerWidth, setdrawerWidth] = useState(120);
  const { window} = props;
  const [mobileOpen, setMobileOpen] = React.useState(false);
 

  

  const { userIsAuthenticated, userLogout } = useAuth();

  // Check if the user is logged in
  const loggedIn = userIsAuthenticated();

  // Logout function
  const logout = () => {
    userLogout();
    setIsInCart(false);
    // Redirect to the homepage or another appropriate page after logout
    navigate("/");
  };

  
  

  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };
 function handleOpen(){
   setMobileOpen(!mobileOpen);
  }
 
  const container = window !== undefined ? () => window().document.body : undefined;
  const navigate=useNavigate();
  const [isInCart,setIsInCart]=useState(false);
  const  SwitchCart= ()=> {
    
    navigate('/cart/get');
    setIsInCart(true);
  }
  const login = () => {
    navigate('/login');
    setMobileOpen(true);
  }
  
  const backHome= ()=>
  {
    navigate('/');
    setIsInCart(false);
  }
  const navigateToOthers= (choosed) => {

    console.log("that one choosed: "+choosed);
   if(choosed=="Hesap")
    {
      navigate('/account');

    }
    else if(choosed=="Sepet")
    {
      navigate('/cart/get');
    }
    else if(choosed=="Siparişler")
    {
      navigate('/cart/purchased');
    } 
  }

  return (
    <>
    
    <Box sx={{ display: 'flex' }}>
    
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{
          width: { sm: `calc(100% - ${drawerWidth}px)` },
          ml: { sm: `${drawerWidth}px` },
        }}
       
      >
        <Toolbar sx={{color:"cyan"}}>
        
          <IconButton
            color="inherit"
            aria-label="open drawer"
            edge="start"
            onClick={handleDrawerToggle}
            sx={{ mr: 2, display: { sm: 'none' } }}
          >
            <MenuIcon />
          </IconButton>
          
          {/* <Typography variant="h6" noWrap component="div">
            Responsive drawer
          </Typography> */}
          <Grid container  justifyContent="flex-start">
          <IconButton sx={{color:'black', backgroundColor:'white', borderRadius:1, ":hover":{color:"white"}}} onClick={backHome}>
            ShoppingTECH
            <LocalMall fontSize='large'/>
            </IconButton>  
          </Grid>
          <Grid container  justifyContent="flex-end">
          
          <IconButton container sx={{color:'black', backgroundColor:'white', borderRadius:1}} size='medium' onClick={SwitchCart} justify="flex-end">
            cart
            <ShoppingCart fontSize='large'/>
            
          </IconButton>
           {
            loggedIn ? 
              <IconButton container sx={{ color: "black", backgroundColor: "white", borderRadius: 1, marginLeft: 2 }} size="medium" onClick={logout} justify="flex-end">
                Logout
               
              </IconButton>
             : 
              <IconButton container sx={{ color: "black", backgroundColor: "white", borderRadius: 1, marginLeft: 2 }} size="medium" onClick={login} justify="flex-end">
                Login
                <LoginIcon />
              </IconButton>
           }
            
          
          </Grid>
          
        </Toolbar>
        
      </AppBar>
      <Box
        component="nav"
        sx={{ width: { sm: drawerWidth }, flexShrink: { sm: 0 } }}
        aria-label="mailbox folders"
      >
        {/* The implementation can be swapped with js to avoid SEO duplication of links. */}
        <Drawer
          container={container}
          variant="temporary"
          color='primary'
          open={mobileOpen}
          onClose={handleDrawerToggle}
          ModalProps={{
            keepMounted: true, // Better open performance on mobile.
          }}
          sx={{
            display: { xs: 'block', sm: 'none' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
            
          }}
        >
            <div>
      <Toolbar />
      <Divider />
      {
      isInCart ?<CartCatalogs/>:<CategoriesComponent />
}
    </div>
        </Drawer>
        <Drawer
          variant="permanent"
          sx={{
            display: { xs: 'none', sm: 'block' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
          }}
          open
        >
            <div>
      <Toolbar />
      <Divider />
    {
      isInCart ?<CartCatalogs/>:<CategoriesComponent />
}
    </div>
        </Drawer>
        
      </Box>
      <Box component="main" sx={{ flexGrow: 1, p: 3,}  } justify="center" alignItems="center">
        <Routes>
          <Route path='/' element={<Welcome/>}/>
          <Route path={`/products/:categoryId`} element={<ProductsComponent/>} />
          <Route path='/product/:productId' element={<ProductsComponent/>}/>
          <Route path='/cart/get' element={<CartDetail/>}/>
          <Route path='/cart/checkout' element={<CartCheckout/>}/>
          <Route path='/login' element={<Login/>}/>
          <Route path='/signup' element={<Signup/>}/>
          <Route path='/cart/purchased' element={<PurchasedCart/>}/>
          <Route path='/account' element={<Account/>}/>
        </Routes>
      </Box>
       
       
     
    </Box>
    </>
  );
}

ResponsiveDrawer.propTypes = {
  /**
   * Injected by the documentation to work in an iframe.
   * You won't need it on your project.
   */
  window: PropTypes.func,
};

export default ResponsiveDrawer;