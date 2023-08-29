import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ApiRequest() {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Send a GET request to your backend API endpoint
    axios.get('http://localhost:8080/api/artworks')
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      {/* Render the fetched data, data contains the data object*/}
      <ul>
      </ul>
    </div>
  );
}

export default ApiRequest;
