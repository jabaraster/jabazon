/**
 * 
 */
package jabara.jabazon.service;

import jabara.jabazon.service.impl.OrderServiceImpl;

import com.google.inject.ImplementedBy;

/**
 * @author jabaraster
 */
@ImplementedBy(OrderServiceImpl.class)
public interface IOrderService {

    void hoge();
}
