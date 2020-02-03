package com.szczeppan.empik.model.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class GithubUser {

  private String login;
  private long id;

  @JsonProperty("node_id")
  private String nodeId;

  @JsonProperty("avatar_url")
  private String avatarUrl;

  @JsonProperty("gravatar_url")
  private String gravatarId;
  private String url;

  @JsonProperty("html_url")
  private String htmlUrl;

  @JsonProperty("followers_url")
  private String followersUrl;

  @JsonProperty("following_url")
  private String followingUrl;

  @JsonProperty("gists_url")
  private String gistsUrl;

  @JsonProperty("starred_url")
  private String starredUrl;

  @JsonProperty("subscriptions_url")
  private String subscriptionsUrl;

  @JsonProperty("organizations_url")
  private String organizationsUrl;

  @JsonProperty("repos_url")
  private String reposUrl;

  @JsonProperty("events_url")
  private String eventsUrl;

  @JsonProperty("received_events_url")
  private String receivedEventsUrl;
  private String type;

  @JsonProperty("site_admin")
  private boolean siteAdmin;
  private String name;
  private String company;
  private String blog;
  private String location;
  private String email;
  private String hireable;
  private String bio;

  @JsonProperty("public_repos")
  private long publicRepos;

  @JsonProperty("public_gists")
  private long publicGists;
  private long followers;
  private long following;

  @JsonProperty("created_at")
  private LocalDateTime createdAt;

  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;

  public GithubUser() {
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getGravatarId() {
    return gravatarId;
  }

  public void setGravatarId(String gravatarId) {
    this.gravatarId = gravatarId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public String getFollowersUrl() {
    return followersUrl;
  }

  public void setFollowersUrl(String followersUrl) {
    this.followersUrl = followersUrl;
  }

  public String getFollowingUrl() {
    return followingUrl;
  }

  public void setFollowingUrl(String followingUrl) {
    this.followingUrl = followingUrl;
  }

  public String getGistsUrl() {
    return gistsUrl;
  }

  public void setGistsUrl(String gistsUrl) {
    this.gistsUrl = gistsUrl;
  }

  public String getStarredUrl() {
    return starredUrl;
  }

  public void setStarredUrl(String starredUrl) {
    this.starredUrl = starredUrl;
  }

  public String getSubscriptionsUrl() {
    return subscriptionsUrl;
  }

  public void setSubscriptionsUrl(String subscriptionsUrl) {
    this.subscriptionsUrl = subscriptionsUrl;
  }

  public String getOrganizationsUrl() {
    return organizationsUrl;
  }

  public void setOrganizationsUrl(String organizationsUrl) {
    this.organizationsUrl = organizationsUrl;
  }

  public String getReposUrl() {
    return reposUrl;
  }

  public void setReposUrl(String reposUrl) {
    this.reposUrl = reposUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  public void setEventsUrl(String eventsUrl) {
    this.eventsUrl = eventsUrl;
  }

  public String getReceivedEventsUrl() {
    return receivedEventsUrl;
  }

  public void setReceivedEventsUrl(String receivedEventsUrl) {
    this.receivedEventsUrl = receivedEventsUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isSiteAdmin() {
    return siteAdmin;
  }

  public void setSiteAdmin(boolean siteAdmin) {
    this.siteAdmin = siteAdmin;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getBlog() {
    return blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHireable() {
    return hireable;
  }

  public void setHireable(String hireable) {
    this.hireable = hireable;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public long getPublicRepos() {
    return publicRepos;
  }

  public void setPublicRepos(long publicRepos) {
    this.publicRepos = publicRepos;
  }

  public long getPublicGists() {
    return publicGists;
  }

  public void setPublicGists(long publicGists) {
    this.publicGists = publicGists;
  }

  public long getFollowers() {
    return followers;
  }

  public void setFollowers(long followers) {
    this.followers = followers;
  }

  public long getFollowing() {
    return following;
  }

  public void setFollowing(long following) {
    this.following = following;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", GithubUser.class.getSimpleName() + "[", "]")
        .add("login='" + login + "'")
        .add("id=" + id)
        .add("nodeId='" + nodeId + "'")
        .add("avatarUrl='" + avatarUrl + "'")
        .add("gravatarId='" + gravatarId + "'")
        .add("url='" + url + "'")
        .add("htmlUrl='" + htmlUrl + "'")
        .add("followersUrl='" + followersUrl + "'")
        .add("followingUrl='" + followingUrl + "'")
        .add("gistsUrl='" + gistsUrl + "'")
        .add("starredUrl='" + starredUrl + "'")
        .add("subscriptionsUrl='" + subscriptionsUrl + "'")
        .add("organizationsUrl='" + organizationsUrl + "'")
        .add("reposUrl='" + reposUrl + "'")
        .add("eventsUrl='" + eventsUrl + "'")
        .add("receivedEventsUrl='" + receivedEventsUrl + "'")
        .add("type='" + type + "'")
        .add("siteAdmin=" + siteAdmin)
        .add("name='" + name + "'")
        .add("company='" + company + "'")
        .add("blog='" + blog + "'")
        .add("location='" + location + "'")
        .add("email='" + email + "'")
        .add("hireable='" + hireable + "'")
        .add("bio='" + bio + "'")
        .add("publicRepos=" + publicRepos)
        .add("publicGists=" + publicGists)
        .add("followers=" + followers)
        .add("following=" + following)
        .add("createdAt=" + createdAt)
        .add("updatedAt=" + updatedAt)
        .toString();
  }
}
