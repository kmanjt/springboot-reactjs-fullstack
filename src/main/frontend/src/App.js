import logo from './logo.svg';
import './App.css';
import axios from "axios";
import React, {useState, useEffect} from "react";

const UserProfiles = () => {

    const fetchUserProfiles = () => {
      axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
        console.log(res);
      });
    }
    useEffect(() => {
      fetchUserProfiles();
    }, []);

    return <h1>Hello World</h1>
}

function App() {
  return (
    <div className="App">
    <UserProfiles />
    </div>
  );
}

export default App;
