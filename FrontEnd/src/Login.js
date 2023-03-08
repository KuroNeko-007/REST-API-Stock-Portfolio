import React from 'react';
import './Login.css';
import { useState } from 'react';
import axios from 'axios';
import { Button } from '@mui/material';

const Login=()=>{
    const[name,setName]=useState(""); 
	const[price,setPrice]=useState(0);
    const[chg,setChg]=useState(0); 
	const[chgper,setChgper]=useState(0);
    const[holding,setHolding]=useState(0);
    const handleSubmit=()=>{
        const data={
            name:name,
            price:price,
            chg:chg,
            chgper:chgper,
            holdings:holding
        }
        axios.post("http://localhost:8080/",data);
    }
    return(
        <form onSubmit={handleSubmit} action='/home'>
            <center>
            <div className='boxlogin'>
                <div className='box2'>
            <div className='textarea'>
            <label>Name :</label>
            <input type="text" name='name' value={name} onChange={(e)=> setName(e.target.value)} />
            </div>
            <div className='textarea'>
            <label>Price :</label>
            <input type="number" 
            step="0.1"
            min='0'
            max='10000'name='price' 
            value={price}  onChange={(e)=> setPrice(e.target.value)}/>
            </div>
            <div className='textarea'>
            <label>Change :</label>
            <input type="number" 
            step="0.1"
            min='-10000'
            max='10000'name='chg' value={chg} onChange={(e)=> setChg(e.target.value)} />
            </div>
            <div className='textarea'>
            <label>Change% :</label>
            <input type="number" 
            step="0.1"
            min='-1000'
            max='1000'name='chg%' 
            value={chgper}  onChange={(e)=> setChgper(e.target.value)}/>
            </div>
            <div className='textarea'>
            <label> Holdings :</label>
            <input type="number" 
            step="0.1"
            max='10000'name='holdings' 
            value={holding}  onChange={(e)=> setHolding(e.target.value)}/>
            </div>
            </div>
            <div className='textarea'>
               <Button type='submit' variant="contained" size="large">ADD</Button>
            </div>
            </div>
            </center>
        </form> 
    )
}
export default Login;  