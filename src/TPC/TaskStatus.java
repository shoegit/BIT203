package TPC;

/**
 * Task Status enumerated type allows only status to be 
 * OUTSTANDING (not done yet)
 * COMPLETED (done already)
 * CANCELLED (don't want to do)
 * @author ngsm
 */
public enum TaskStatus {
    OUTSTANDING, COMPLETED, CANCELLED;
}
