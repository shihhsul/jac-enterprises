import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ArtworksList() {
  const [artworks, setArtworks] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    async function fetchArtworks() {
      try {
        const response = await axios.get(
          'https://collectionapi.metmuseum.org/public/collection/v1/objects'
        );
        setArtworks(response.data.objectIDs);
        setIsLoading(false); // Set loading state to false
      } catch (error) {
        console.error('Error fetching artworks:', error);
        setError(error); // Set error state
        setIsLoading(false); // Set loading state to false
      }
    }
    fetchArtworks();
  }, []);

  if (isLoading) {
    return <div>Loading...</div>; // Display loading indicator
  }

  if (error) {
    return <div>Error: {error.message}</div>; // Display error message
  }

  return (
    <div>
      <h2>Artworks List</h2>
      <ul>
        {artworks.map((objectId) => (
          <li key={objectId}>{objectId}</li>
        ))}
      </ul>
    </div>
  );
}

export default ArtworksList;