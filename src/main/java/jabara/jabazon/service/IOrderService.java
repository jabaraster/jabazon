/**
 * 
 */
package jabara.jabazon.service;

import jabara.jabazon.entity.Order;
import jabara.jabazon.service.impl.OrderServiceImpl;

import com.google.inject.ImplementedBy;

/**
 * @author jabaraster
 */
@ImplementedBy(OrderServiceImpl.class)
public interface IOrderService {

    /**
     * @return -
     */
    Order order();
}
