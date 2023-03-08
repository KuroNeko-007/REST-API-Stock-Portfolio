
import Home from './home';
import Login from './Login';
import Edit from './edit';
import { useParams } from 'react-router-dom';
import { Route,Routes} from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <header className="App-header">
      <Routes>
        <Route path="/" element={<Login/>}></Route>
        <Route path="/home" element={<Home/>}></Route>
        {/* <Route path="/" element={</>}></Route> */}
        <Route path="/home/edt/:id" element={<Edit/>}></Route>
      </Routes>   
      </header>
    </div>
  );
}

export default App;
