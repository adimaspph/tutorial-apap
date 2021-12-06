import React from "react";
import Button from "../button";
import classes from "./styles.module.css";

const Item = (props) => {
    const { id, title, price, description, category, quantity, isCart, handleInput, handleEdit, handleDelete, handleCart} = props;

    const totalHarga = price*quantity;
    if (isCart===true) {
        return (
            <div className={classes.item}>
                <h3>{`ID ${id}`}</h3>
                <p>{`Nama Barang: ${title}`}</p>
                <p>{`Harga: ${price}`}</p>
                <p>{`Jumlah: ${quantity}`}</p>
                <p>{`Deskripsi: ${description}`}</p>
                <p>{`Kategori: ${category}`}</p>
                <h3>{`Total Harga: ${totalHarga}`}</h3>
            </div>
        );
    }

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
