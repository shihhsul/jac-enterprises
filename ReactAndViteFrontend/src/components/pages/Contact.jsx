import Style from "../Contact Page Components/style.css"

const Contact = () => {

  return (
    <>
      <header id="showcase" className="grid">
        <div className="bg-image"></div>
        <div className="content-wrap">
          <h1>Welcome to Jac Enterprises</h1>
          <p>We are an organization that specializes in offering niche adventures dedicated to learning about Earth's various ecosystems and unique terrains. Our motto is, "Vincit Qui Se Vincit" which means, "He/she conquers who conquers him/herself."</p>
        </div>
      </header>

      
      <main id="main">
        {/* Section A */}
        <section id="section-a" className="grid">
          <div className="content-wrap">
            <h2 className="content-title">Adventure Offerings</h2>
            <div className="content-text">
              <p>JacKr prides itself on educating all their clients on what adventures are provided and what can be expected on a chosen adventure.  Jac is constantly changing and seeking to innovate adventures that offer the ultimate in adventure excitement in a fun and safe way.  Past adventures offered include JacKr's Spelunking!, EYA! bka Experience Your Aquarium!,  Skip 2 My Cay! aka Island Hopping, JT,B! bka Just Trek Baby!, and Twitchers! adventures.</p>
            </div>
          </div>
        </section>

        {/* Section B */}
<section id="section-b" className="grid">
  <ul>
    <li>
      <div className="card">
        <img src="ReactAndViteFrontend/src/components/Contact Page Components/images/redsea-1-1024x768.jpg" alt="EYA Adventure" />
        <div className="card-content">
          <h3 className="card-title">EYA!&#8482</h3>
          <p>Own an aquarium? Enjoy visiting major aquariums? Love to visit the tropical fish store? Is the answer...YES! Come experience those questions...LIVE AND IN LIVING COLOR!</p>
        </div>
      </div>
    </li>
    <li>
      <div className="card">
        <img src="ReactAndViteFrontend/src/components/Contact Page Components/images/cavern.jpg" alt="Spelunking Adventure" />
        <div className="card-content">
          <h3 className="card-title">Spelunking!&#8482</h3>
          <p>Sure. The tourist caves are beautiful, fun, and unique to visit. But why do the tourist thing when you can tame the wilds and mark new paths for future tourists to follow.</p>
        </div>
      </div>
    </li>
    <li>
      <div className="card">
        <img src="ReactAndViteFrontend/src/components/Contact Page Components/images/fiji-islands.jpg" alt="Skip 2 My Cay Adventure" />
        <div className="card-content">
          <h3 className="card-title">Skip 2 My Cay!&#8482</h3>
          <p>What's the fun in just exploring that single island you flew into?! Why not explore a subset of that island's chain? so just take the opportunity to...Skip to My Cay!&#8482</p>
        </div>
      </div>
    </li>
    <li>
      <div className="card">
        <img src="ReactAndViteFrontend/src/components/Contact Page Components/images/trek-to-k2-2.jpg" alt="JT,B Adventure" />
        <div className="card-content">
          <h3 className="card-title">JT,B!™</h3>
          <p>"Just Trek Baby!&#8482" is what we say here at Jac.  Come test your fortitude with treks that make you forget that the word civilization even exists.</p>
        </div>
      </div>
    </li>
    <li>
      <div className="card">
        <img src="ReactAndViteFrontend/src/components/Contact Page Components/images/toucan-barbet.jpg" alt="Twitchers Adventure" />
        <div className="card-content">
          <h3 className="card-title">Twitchers!™</h3>
          <p>“There are approximately ten thousand species of birds on the planet and no single individual has seen them all. -Bernd Brunner”...Accept the challenge!</p>
        </div>
      </div>
    </li>
  </ul>
</section>

{/* Section C */}
<section id="section-c" className="grid">
  <div className="content-wrap">
    <h2 className="content-title">Jac will handle all your cravings for adventure</h2>
    <p>EYA!&#8482, Spelunking!&#8482, Skip 2 My Cay!&#8482, JT,B!&#8482, and Twitchers!&#8482 are just a sampling of the various exhilarating and thrilling eco-friendly global outdoor adventure.</p>
  </div>
</section>

{/* Section D */}
<section id="section-d" className="grid">
  <div className="box">
    <h2 className="content-title">Contact Us</h2>
    <p>2645 N High Street Columbus, OH 43202</p>
    <p>1.844.932.2626</p>
    <p>greatadventures@jac.biz</p>
  </div>
  <div className="box">
    <h2 className="content-title">About Our Company</h2>
    <p>Founded in 2019 by a group of wild and crazy individuals for a tremendous love for the great outdoors and the many adventures the Earth has to offer. These fab people chose to start guiding friends, family, and co-workers on the many adventures that they had experienced over their many years. And due to the number of requests for guiding, <strong>Jac</strong> was born.</p>
  </div>
</section>
</main>

        {/* Footer */}
        <footer id="main-footer" className="grid">
          <div>Jac Enterprises</div>
          <div>Web Site Created By <a href="http://wecancodeit.org" target="_blank" rel="noreferrer">We Can Code IT</a></div>
        </footer>
      </>
  );
}
export default Contact