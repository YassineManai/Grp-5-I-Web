import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Form, Alert } from "react-bootstrap";
import { Button } from "react-bootstrap";
import { useUserAuth } from "../context/UserAuthContext";

const Signup = () => {
  const [email, setEmail] = useState("");
  const [error, setError] = useState("");
  const [password, setPassword] = useState("");
  const { signUp } = useUserAuth();
  let navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    try {
      await signUp(email, password);
      navigate("/");
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <>

<div className="login">
                <div className="loginContainer">


                    <Form onSubmit={handleSubmit}>
                        <label>Username</label>
                        <input controlId="formBasicEmail"
                            type="email"
                            placeholder="Enter your Email"
                            onChange={(e) => setEmail(e.target.value)}
                        >
                        </input>
                        {error && <Alert variant="danger">{error}</Alert>}

                        <label> Password</label>
                        <input controlId="formBasicPassword"
                            type="password"
                            placeholder="Enter your Password"
                            onChange={(e) => setPassword(e.target.value)}>

                        </input>



                        <div className="btnContainer">
                            <Button variant="primary" type="Submit">
                                Sign up
                            </Button>
                            <hr />
                           
                            
                                <p> Already have an account? <Link to="/"><span>Log in</span></Link>
                            </p>
                        </div>
                    </Form>



                </div>





            </div>













































      
        
       

         

          <div className="d-grid gap-2">
            <Button variant="primary" type="Submit">
              Sign up
            </Button>
          </div>
      
    
      <div className="p-4 box mt-3 text-center">
        Already have an account? <Link to="/">Log In</Link>
      </div>
    </>
  );
};

export default Signup;
