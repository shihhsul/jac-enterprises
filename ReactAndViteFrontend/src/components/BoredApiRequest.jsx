import React, { useState, useEffect } from 'react';
import axios from 'axios';

function BoredApiRequest() {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Send a GET request to your backend API endpoint
    axios.get('http://localhost:8080/api/bored/random')
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
            <h2>{data.activity}</h2>
            <p>Participants: {data.participants}</p>
            <p>Accessibility: {data.accessibility}</p>
            <img src={data.link} alt="link" />
    </div>
  );
}

export default BoredApiRequest;
