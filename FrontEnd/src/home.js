import React, { Component } from "react";
import axios from "axios";
import Dis from "./dis";
import './dis.css';
import { Link } from "react-router-dom";
import { Button } from "@mui/material";
class Home extends Component{
    constructor(props){
        super(props);
        this.state={
            data:[]
        }
    }
    componentDidMount() {
        axios.get("http://localhost:8080/")
          .then(response => {
            this.setState({data:response.data});
        })
        console.log(this.state.data);
    }   
    handleDelete(id){
          axios.delete("http://localhost:8080/" + id)
        this.setState({data:this.state.data.filter(n=>n.id!==id)});
            
        }
            render(){
                return (
                    <div className="home">
            <div className="table">
                <div className="box">
                <div className="cont1">
                    <p>NAME</p>
                </div>
                <div className="cont1">
                <p>PRICE</p>
                </div>
                <div className="cont1">
                <p>CHANGE</p>
                </div>
                <div className="cont1">
                <p>CHANGE %</p>
                </div>
                <div className="cont1">
                <p>HOLDINGS</p> 
                </div>
                <div className="cont1">
                <p></p> 
                </div>
                </div>

                {this.state.data.map((n)=>{
                    return(
                        <div className="h">
                        <Dis name={n.name} id={n.id} price={n.price} chg={n.chg} chgper={n.chgper}  holdings={n.holdings} /> 
                        {/* <button onClick={()=>{this.handleDelete(n.id)}}>delete</button> */}
                        <Button  style={{width:100,marginLeft:1325}} variant="contained" color="error" onClick={()=>{this.handleDelete(n.id)}}>DELETE</Button>
                        </div>
                        )
                    })}
                        <center>
                    <Link to="/"><Button type='submit' style={{margin:'10px'}} color="success" variant="contained"  size="large">ADD</Button></Link>
                        </center>
            </div>
        </div>
      )
    }       
}
export default Home