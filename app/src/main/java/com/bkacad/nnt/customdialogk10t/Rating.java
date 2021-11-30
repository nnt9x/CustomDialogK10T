package com.bkacad.nnt.customdialogk10t;

public class Rating {
    private float rating;
    private String comment;

    public Rating(float rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Rating() {
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
