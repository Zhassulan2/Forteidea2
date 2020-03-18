package com.fortebank.forteidea.dto.idea;

public class IdeaRateActionDTO {
    private int likeAmount;
    private int dislikeAmount;

    public IdeaRateActionDTO() {
    }

    public IdeaRateActionDTO(int likeAmount, int dislikeAmount) {
        this.likeAmount = likeAmount;
        this.dislikeAmount = dislikeAmount;
    }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }

    public int getDislikeAmount() {
        return dislikeAmount;
    }

    public void setDislikeAmount(int dislikeAmount) {
        this.dislikeAmount = dislikeAmount;
    }
}
