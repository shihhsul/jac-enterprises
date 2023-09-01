import React from 'react';
import styles from './CombinedApiPage.module.css';
import BoredApiRequest from '../BoredApiRequest';
import NasaApiRequest from '../NasaApiRequest';

function CombinedApiPage() {
  return (
    <div className={styles.container}>
      <div className={styles.card}>
        <div className={styles.imgbox}>
            <img src="https://1000logos.net/wp-content/uploads/2017/03/NASA-Logo.jpg"></img>
        </div>
      <div className={styles.textbox}>
        <h3>Nasa</h3>
        <NasaApiRequest />
        </div>
      </div>
      <div className={styles.card}>
        <div className={styles.imgbox}>
            <img src="https://img.freepik.com/premium-vector/light-bulb-with-rays-shine-cartoon-style-flat-style-hand-drawn-style-doodle-style-symbol-creativity-innovation-inspiration-invention-idea-vector-illustration_175838-3305.jpg"></img>
        </div>
      <div className={styles.textbox}>
        <h3>Bored</h3>
        <BoredApiRequest />
        </div>
      </div>
    </div>
  );
}

export default CombinedApiPage;