import { Route, Routes } from 'react-router'
//import ApiRequest from './components/apiRequest'
import Layout from './components/layout/Layout'
import About from './components/pages/About'
import Contact from './components/pages/Contact'
import Main from './components/pages/Main'
import BoredApiRequest from './components/BoredApiRequest'
import NasaApiRequest from './components/NasaApiRequest'

function App() {

  return (
<Layout>
<Routes>
<Route path='/' element={<Main/>}/>
<Route path="/About" element={<About />} />
<Route path="/Contact" element={<Contact/>} />
</Routes>
</Layout>
/*<NasaApiRequest/>
<BoredApiRequest/> */
  )
}

export default App
