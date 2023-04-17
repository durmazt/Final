import logo from './logo.svg';
import './App.css';

import Sidenav from './Sidenav';
import {Routes,Route} from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';

export default function App() {
 
  return (
    <>
     
     <AuthProvider>
     <Sidenav/>
     </AuthProvider>
      
     
     
    </>
  );
}


