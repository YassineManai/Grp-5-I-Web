import React from "react";
import Pictogramme from "./Pictogramme";
import Commentaire from "./Commentaire";
import 'font-awesome/css/font-awesome.min.css';


class App extends React.Component {










  render() {



    return (
      <div className="col-6 offset-3">
        <div className="card">
          <div className="card-block">
            <div className="row">
              <div className="col-2">
                <img src="https://thomas-bart.com/wp-content/uploads/2017/03/developper-1680x1201.jpg" class="rounded float-left" className="img-thumbnail" width="80" height="70" />
              </div>
              <div className="col-10 profile-row">
                <div className="row">
                  <a href="#"><h1> Débuter avec React </h1></a>
                </div>
              </div>
            </div>

            <p>{this.state.msg}</p>



            <div>
              <Pictogramme />
            </div>
          </div>

          <div className="card-footer text-muted">
            <Commentaire />
          </div>

        </div>
      </div>









    )
  }
}
export default App;
