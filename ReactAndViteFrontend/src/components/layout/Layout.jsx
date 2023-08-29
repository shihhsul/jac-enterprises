import Nav from "./Nav";
import style from "./Layout.module.css";

const Layout = (props) => {
  return (
    <div>
      <main className={style.main}>{props.children}</main>
      <Nav />
    </div>
  );
};

export default Layout;
