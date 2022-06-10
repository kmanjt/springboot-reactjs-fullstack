import logo from './logo.svg';
import './App.css';
import axios from "axios";
import React, {useState, useEffect, useCallback} from "react";
import { useDropzone } from "react-dropzone";

function Dropzone() {
  const onDrop = useCallback(acceptedFiles => {
    // Do something with the files
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <p>Drag 'n' drop some files here, or click to select files</p>
      }
    </div>
  )
}



const UserProfiles = () => {

    const [userProfiles, setUserProfiles] = useState([]);

    const fetchUserProfiles = () => {
      axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
        console.log(res);
        setUserProfiles(res.data);
      });
    }
    useEffect(() => {
      fetchUserProfiles();
    }, []);

    return userProfiles.map((userProfile, index) => {
      return (<div key={index}>
        <Dropzone />
        <h1>{userProfile.username}</h1>
        <p>{userProfile.userProfileId}</p>
      </div>);
    });
};

function App() {
  return (
    <div className="App">
    <UserProfiles />
    </div>
  );
}

export default App;
