import React, { Component, useContext } from 'react'

const AuthContext = React.createContext()

class   AuthProvider extends Component {
  state = {
    user: null,
    loading: true, // Add loading state
  };

  componentDidMount() {
    const user = localStorage.getItem("user");
    this.setState({ user, loading: false }); // Set loading state to false
  }

  getUser = () => {
    return JSON.parse(localStorage.getItem('user'))
  }

  userIsAuthenticated = () => {
    let user = localStorage.getItem('user');
    if (!user) {
      return false;
    }
    user = JSON.parse(user);
  
    // Check if user and user.data are defined
    if (!user || !user.data) {
      return false;
    }
  
    // if user has token expired, logout user
    if (Date.now() > user.data.exp * 1000) {
      this.userLogout();
      return false;
    }
    return true;
  };

  userLogin = (result) => {
    const newUser = {
      data: {
        id: result.id,
        username: result.username,
        email: result.email,
        roles: result.roles,
        tokenType: result.tokenType,
        accessToken: result.accessToken,
      },
    };
  
    localStorage.setItem('user', JSON.stringify(newUser));
    this.setState({ user: newUser });
  };

  userLogout = () => {
    localStorage.removeItem('user')
    this.setState({ user: null })
  }

  render() {
    const { children } = this.props
    const { user, loading } = this.state // Destructure loading from state
    const { getUser, userIsAuthenticated, userLogin, userLogout } = this

    return (
      <AuthContext.Provider value={{ user, loading, getUser, userIsAuthenticated, userLogin, userLogout }}>
      {children}
    </AuthContext.Provider>
    )
  }
}

export default AuthContext

export function useAuth() {
  return useContext(AuthContext)
}

export { AuthProvider }