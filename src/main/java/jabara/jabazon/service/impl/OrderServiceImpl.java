package jabara.jabazon.service.impl;

import jabara.jabazon.entity.Order;
import jabara.jabazon.service.IOrderService;
import jabara.jpa_guice.DaoBase;

/**
 * @author jabaraster
 */
public class OrderServiceImpl extends DaoBase implements IOrderService {
    private static final long serialVersionUID = -4229546207681718332L;

    /**
     * @see jabara.jabazon.service.IOrderService#order()
     */
    @Override
    public Order order() {
        piyo();
        jabara.Debug.write();
        return new Order();
    }

    /**
     * 
     */
    @SuppressWarnings("static-method")
    public void piyo() {
        jabara.Debug.write();
    }
}
