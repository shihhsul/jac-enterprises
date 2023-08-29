import Nav from "./Nav";
import style from "./Layout.module.css";

const Layout = (props) => {
  return (
    <div>
          <Nav />
      <main className={style.main}>{props.children}</main>
    </div>
  );
};

export default Layout;
