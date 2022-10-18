import React from "react";
import Icon from "./Icon";
import App from "./App";
class Pictogramme extends React.Component {
    render() {
        return (
            <div>
                {/* Inclut le sous-composant LikeIcon à l'intérieur du composant Like*/}
                <Icon />
                <hr />
                <div>
                    <button type="button" className="btn no-outline btn-secondary">
                        <i className="fa fa-thumbs-o-up fa-4 align-middle" aria-hidden="true"></i>
                        &nbsp;
                        <span className="align-middle">J'aime</span>
                    </button>
                </div>
            </div>
        )
    }
}
export default Pictogramme;