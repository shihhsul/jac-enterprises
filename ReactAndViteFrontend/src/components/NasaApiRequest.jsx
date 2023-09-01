import React, { useState, useEffect } from 'react';
import axios from 'axios';

function NasaApiRequest() {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Send a GET request to your backend API endpoint
    axios.get('http://localhost:8080/api/nasa/random')
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
            <h2>{data.title}</h2>
            <p>Author: {data.author}</p>
            <p>Summary: {data.summary}</p>
            <img src={data.image} alt="Article" />
    </div>
  );
}

export default NasaApiRequest;
