import React, { useState, useEffect } from 'react';
import axios from 'axios';

function NasaApiRequest() {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Send a GET request to your backend API endpoint
    axios.get('http://localhost:8080/api/nasa/findall')
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
            <h2>{article.title}</h2>
            <p>Author: {article.author}</p>
            <p>Summary: {article.summary}</p>
            <img src={article.image} alt="Article" />
          </li>
        ))}
      </ul>
    </div>
  );
}

export default NasaApiRequest;
