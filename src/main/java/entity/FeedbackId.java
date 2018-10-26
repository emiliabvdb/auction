package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class FeedbackId implements Serializable {

    @Basic
    @Column(name = Feedback.AUCTION_ID, nullable = false)
    private Long id;

    @Basic
    @Column(name = Feedback.BIDDER_ID, nullable = false)
    private String email;
}
