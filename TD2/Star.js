import { render } from "@testing-library/react";
import React from "react";

class Star extends React.Component {
    constructor(props) {
        super(props);
        this.state = { on: false };
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
       
       if (this.state.on==true){
        this.setState({ on: false  });

       }
       else {
        this.setState({ on: true  });
       }
      
    
    }
    render(){
        return (
            
            <img  src={this.state.on ? process.env.PUBLIC_URL + '/star_On.png' :
                process.env.PUBLIC_URL + '/star_Off.png'}
                onClick={this.handleClick}
            />
        );
    }
    
} 
export default Star ;




