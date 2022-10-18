import React from "react";
import Pictogramme from "./Pictogramme";
import Commentaire from "./Commentaire";
import 'font-awesome/css/font-awesome.min.css';


class App extends React.Component {

  affiche=()=>{
    let msj=""
    
    let y = new Date().getHours()
   if (y<12  && y>5){
     msj+="matin"
   }
   else if ( (y >= 12) && (y <= 20)){
     msj +="apres midi"
   }
     else {
     msj+="soir"
   }
   return msj }








  render() {



    return (
      
      <h1>{this.affiche()}</h1>









    )
  }
}
export default App;
