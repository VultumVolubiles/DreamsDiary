package com.example.dreamsdiary;

public class NoteTheme {
    public int backgroundColor;
    public int backgroundRectangle;
    public int iconFavorite;
    public int iconLicuid;

    public NoteTheme(String noteColor, int favorite, int licuid) {
        switch (noteColor) {
            case "#F75B50": {
                this.backgroundColor = R.color.colorNoteBackgroundTheme1;
                this.backgroundRectangle = R.drawable.rectangle_theme1;
            }

            case "#4D944A": {
                this.backgroundColor = R.color.colorNoteBackgroundTheme2;
                this.backgroundRectangle = R.drawable.rectangle_theme2;
                break;
            }
            default: {
                this.backgroundColor = R.color.colorBackground;
                this.backgroundRectangle = R.drawable.rectangle;
                break;
            }
        }
        switch (favorite) {
            case 1: {
                this.iconFavorite = R.drawable.ic_favorite_enabled;
                break;
            }
            default: {
                this.iconFavorite = R.drawable.ic_favorite;
                break;
            }
        }
        switch (licuid) {
            case 1: {
                this.iconLicuid = R.drawable.ic_licuid_enabled;
                break;
            }
            default: {
                this.iconLicuid = R.drawable.ic_licuid;
                break;
            }
        }
    }
}

