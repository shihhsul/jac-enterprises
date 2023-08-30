import React, { useState, useEffect } from 'react';
import axios from 'axios';

function BoredApiRequest() {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Send a GET request to your backend API endpoint
    axios.get('http://localhost:8080/api/bored/findall')
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <ul>
        {/* Map through the data array and render each item */}
        {data.map(article => (
          <li key={article.id}>
            <h2>{article.activity}</h2>
            <p>Author: {article.participants}</p>
            <p>Summary: {article.accessibility}</p>
            <img src={article.link} alt="link" />
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BoredApiRequest;
