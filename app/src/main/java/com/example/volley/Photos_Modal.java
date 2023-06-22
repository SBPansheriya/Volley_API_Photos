package com.example.volley;


public class Photos_Modal {

private Integer albumId;

private Integer id;

private String title;

private String url;

    public Photos_Modal(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    private String thumbnailUrl;


    public Integer getAlbumId() {
return albumId;
}

public void setAlbumId(Integer albumId) {
this.albumId = albumId;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getThumbnailUrl() {
return thumbnailUrl;
}

public void setThumbnailUrl(String thumbnailUrl) {
this.thumbnailUrl = thumbnailUrl;
}

}