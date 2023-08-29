import { Link } from "react-router-dom";
import "./Nav.css";

const Nav = () => {
  return (
    <header className="header">
      <div className="logo"> </div>
      <nav>
        <ul>
          <li>
            <Link to="/About">About</Link>
          </li>
          <li>
            <Link to="/Contact">Contact</Link>
          </li>
          <li>
            <Link to="/">Main</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Nav;
