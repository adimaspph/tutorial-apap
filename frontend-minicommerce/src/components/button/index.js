import React from "react";
import classes from "./styles.module.css";

const Button = (props) => {
    const { action, children, tipe } = props;

    if (tipe === "danger") {
        return (
            <button className={classes.danger + " " + classes.button} onClick={action}> {children}
            </button>
        );
    } else if (tipe === "success") {
        return (
            <button className={classes.success + " " + classes.button} onClick={action}> {children}
            </button>
        );
    } 
    else {
        return (
            <button className={classes.primary + " " + classes.button} onClick={action}> {children}
            </button>
        )
    }
    
}

export default Button;