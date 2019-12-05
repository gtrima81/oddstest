package oddtest.apigenerated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Odds
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-05T17:57:19.849984Z[Europe/London]")

public class Odds {
  @JsonProperty("betId")
  private Long betId;

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("odds")
  private String odds;

  public Odds betId(Long betId) {
    this.betId = betId;
    return this;
  }

  /**
   * Get betId
   * @return betId
  */
  @ApiModelProperty(value = "")


  public Long getBetId() {
    return betId;
  }

  public void setBetId(Long betId) {
    this.betId = betId;
  }

  public Odds userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ID of user who is offering the odds
   * @return userId
  */
  @ApiModelProperty(value = "ID of user who is offering the odds")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Odds odds(String odds) {
    this.odds = odds;
    return this;
  }

  /**
   * Get odds
   * @return odds
  */
  @ApiModelProperty(example = "1/10", value = "")


  public String getOdds() {
    return odds;
  }

  public void setOdds(String odds) {
    this.odds = odds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Odds odds = (Odds) o;
    return Objects.equals(this.betId, odds.betId) &&
        Objects.equals(this.userId, odds.userId) &&
        Objects.equals(this.odds, odds.odds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(betId, userId, odds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Odds {\n");

    sb.append("    betId: ").append(toIndentedString(betId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    odds: ").append(toIndentedString(odds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

