// import { title } from 'process'
import  style  from './Main.module.css'
import { useState, useEffect } from 'react';
import axios from 'axios';

const Main = () => {
  const [nasaData, setNasaData] = useState([]);
  const [boredData, setBoredData] = useState([]);

  useEffect(() => {
    axios.get(`/api/nasa/new`)
      .then(response => {
        setNasaData(response.data);
      })
      .catch(error => {
        console.error("Error fetching nasa data:", error);
      });
      
    axios.get(`/api/bored/new`)
      .then(response => {
        setBoredData(response.data);
      })
      .catch(error => {
        console.error("Error fetching bored data:", error);
      });

  }, []);

  return (
    <div className={style.container}>

    <div className={style.card}>
        <div className={style.imgbox}>
            <img src="https://1000logos.net/wp-content/uploads/2017/03/NASA-Logo.jpg"></img>
        </div>
      <div className={style.textbox}>
        <h3>Nasa</h3>
        {nasaData ? (
          <p>{nasaData.nasaArticles}</p>
        ) : (
          <p>Loading Nasa data...</p>
        )}
        </div>
      </div>
      <div className={style.card}>
        <div className={style.imgbox}>
            <img src="https://img.freepik.com/premium-vector/light-bulb-with-rays-shine-cartoon-style-flat-style-hand-drawn-style-doodle-style-symbol-creativity-innovation-inspiration-invention-idea-vector-illustration_175838-3305.jpg"></img>
        </div>
      <div className={style.textbox}>
        <h3>Bored</h3>
        {boredData ? (
          <p>{boredData.boredArticles}</p>
        ) : (
          <p>Loading bored data...</p>
        )}
        </div>
      </div>
    </div>
  );
};
export default Main;