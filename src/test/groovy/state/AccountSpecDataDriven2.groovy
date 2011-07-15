package state

import spock.lang.Specification
import spock.lang.Unroll

class AccountSpecDataDriven2 extends Specification {
    @Unroll("withdrawing #withdrawn from account with balance #balance")
    def "withdraw an amount"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(withdrawn)

        then:
        account.balance == old(account.balance) - withdrawn

        where:
        balance | withdrawn
        5.0     | 2.0
        4.0     | 0.0
        4.0     | 4.0
    }
}
