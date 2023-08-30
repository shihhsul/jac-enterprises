import AboutItem from "../layout/AboutItem";
import style from "./AboutList.module.css";
import PropTypes from "prop-types";

const AboutList = (props) => {
  return (
    <ul className={style.list}>
      {props.abouts.map((about) => (
        <AboutItem
          key={about.id}
          name={about.name}
          image={about.image}
          biography={about.biography}
        />
      ))}
    </ul>
  );
};

AboutList.propTypes = {
abouts: PropTypes.string
};

export default AboutList;
