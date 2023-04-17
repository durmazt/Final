import React, { useState } from "react";
import {
  FormControl,
  Input,
  InputLabel,
  Button,
  Typography,
  Paper,
  Grid,
} from "@material-ui/core";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

export default function Signup() {
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [isError, setIsError] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
    const { userLogin } = useAuth();
    const navigate = useNavigate();
   const state = {
      name: name,
      surname: surname,
      username: email,
      email: email,
      role: ['user'],
      password: password,
    }
    /**
     * {
    
    "name":"durmaz",
    "surname":"tekeli",
    "username": "dt@durmaz.me",
    "email":"dt@durmaz.me",
    "role":["user"],
    "password":"durmazt"
}
     */
  
    const handleSignup = (event) => {
      event.preventDefault();
    const {name, surname, username, email,role, password} = state;
  
    if (!(password && name && surname && email)) {
      this.setState({
        isError: true,
        errorMessage: 'Please, inform all fields!'
      })
      return
    }
    if (password !== confirmPassword) {
      setIsError(true);
      setErrorMessage("Passwords do not match!");
      return;
    }

    const user = { username, password, name, email }
    const url = 'http://localhost:8081/api/auth/signup';
    fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(state),
    })
      .then((response) => response.json())
      .then((result) => {
        userLogin(result); // Use the userLogin function from AuthContext
        navigate("/");
        console.log(result);
      })
      .catch((error) => {
        console.error(error);
      });
     
    };
  
    return (
      <Grid container justifyContent="center" alignItems="center" style={{ height: "100vh" }}>
        <Grid item xs={10} sm={8} md={6} lg={4}>
          <Paper style={{ padding: 16 }}>
            <Typography variant="h5" align="center" gutterBottom>
              Signup
            </Typography>
            <form onSubmit={handleSignup}>
            <FormControl fullWidth margin="normal">
                <InputLabel htmlFor="name">Name</InputLabel>
                <Input
                  id="name"
                  type="name"
                  value={name}
                  onChange={(event) => setName(event.target.value)}
                />
              </FormControl>
              <FormControl fullWidth margin="normal">
                <InputLabel htmlFor="surname">Surname</InputLabel>
                <Input
                  id="surname"
                  type="surname"
                  value={surname}
                  onChange={(event) => setSurname(event.target.value)}
                />
              </FormControl>
              <FormControl fullWidth margin="normal">
                <InputLabel htmlFor="email">Email address</InputLabel>
                <Input
                  id="email"
                  type="email"
                  value={email}
                  onChange={(event) => setEmail(event.target.value)}
                />
              </FormControl>
              <FormControl fullWidth margin="normal">
                <InputLabel htmlFor="password">Password</InputLabel>
                <Input
                  id="password"
                  type="password"
                  value={password}
                  onChange={(event) => setPassword(event.target.value)}
                />
              </FormControl>
              <FormControl fullWidth margin="normal">
                <InputLabel htmlFor="confirmPassword">Confirm Password</InputLabel>
                <Input
                  id="confirmPassword"
                  type="password"
                  value={confirmPassword}
                  onChange={(event) => setConfirmPassword(event.target.value)}
                />
              </FormControl>
              {isError && (
              <Typography color="error" align="center">
                {errorMessage}
              </Typography>
                 )}
              <Button variant="contained" color="primary" type="submit" fullWidth>
                Signup
              </Button>
            </form>
          </Paper>
        </Grid>
      </Grid>
    );
  }