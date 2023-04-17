import React, { useState, useContext } from "react";
import { FormControl, Input, InputLabel, Button, Typography, Paper, Grid } from "@material-ui/core";
import  AuthContext  from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const Auth = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogin = (event) => {
    event.preventDefault();

    const url = 'http://localhost:8081/api/auth/signin';
    const data = { username, password };

    fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((result) => {
        Auth.userLogin(result);
        navigate("/");
        
      })
      .catch((error) => {
        console.error(error);
      });
  };
 
  const handleSignup = () => {
    navigate("/signup");
  };

  return (
    <Grid container alignItems="center" alignContent="center" justifyContent="center" style={{ height: "100vh" }}>
      <Grid item xs={10} sm={8} md={6} lg={4}>
        <Paper style={{ padding: 16 }}>
          <Typography variant="h5" align="center" gutterBottom>
            Login
          </Typography>
          <form onSubmit={handleLogin}>
            <FormControl fullWidth margin="normal">
              <InputLabel htmlFor="email">Email address</InputLabel>
              <Input id="email" type="email" value={username} onChange={(event) => setUsername(event.target.value)} />
            </FormControl>
            <FormControl fullWidth margin="normal">
              <InputLabel htmlFor="password">Password</InputLabel>
              <Input id="password" type="password" value={password} onChange={(event) => setPassword(event.target.value)} />
            </FormControl>
            <Button variant="contained" color="primary" fullWidth sx={{ marginTop: 2 }} type="submit">
              Login
            </Button>
            <Button variant="contained" color="secondary" fullWidth sx={{ marginTop: 3 }} onClick={handleSignup}>
              Signup
            </Button>
          </form>
        </Paper>
      </Grid>
    </Grid>
  );
}