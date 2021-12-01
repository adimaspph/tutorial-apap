import React from "react";
import Button from "../button";
import classes from "./styles.module.css";

const Item = (props) => {
    const { id, title, price, description, category, quantity, handleInput, handleEdit, handleDelete, handleCart} = props;

    // let jumlah;
    // function handleInput(e) {
    //     // props.jumlah = (e.target.value);
    //     console.log(props.jumlah);
    // };

    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit} tipe="primary">
                Edit
            </Button>
            <Button action={handleDelete} tipe={"danger"} >
                Delete
            </Button>
            
            <input className={classes.textField} type="number" id="jumlah" name="jumlah" onKeyUp={handleInput} placeholder="Jumlah Barang"/>
            <Button action={handleCart} tipe="success">
                Add To Cart
            </Button>
        </div>
    );
};

export default Item;
