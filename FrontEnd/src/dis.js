import { Link } from 'react-router-dom';
import './dis.css';
import { Button } from '@mui/material';
const Dis=(props)=>{

        return(
            <div className="box">
                <div className="cont">
                    {props.name}
                </div>
                <div className="cont">
                    {props.price}
                </div>
                <div className="cont">
                    {props.chg}
                </div>
                <div className="cont">
                    {props.chgper}%
                </div>
                <div className="cont">
                    {props.holdings}
                </div>
                <div className="cont">
                {/* <button  variant="contained" color="error" onClick={()=>{props.handleDelete(props.id)}}>DELETE</button> */}
                
                        <Link to ={"/home/edt/"+props.id}><Button  variant="contained" >EDIT</Button></Link> 
                </div>   
            
            </div>
        )
    }
export default Dis;