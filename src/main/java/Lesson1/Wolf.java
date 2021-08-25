package Lesson1;

public class Wolf extends Animal implements Jump
{
    private final int RUN_LIMIT = 100;
    private final float JUMP_LIMIT = 10f;
    private float jump_limit;

    public Wolf(String name)
    {
        this.name = name;
        this.run_limit = RUN_LIMIT;
        jump_limit = JUMP_LIMIT;
    }

    public Wolf(String name, int run_limit, float jump_limit)
    {
        this.name = name;
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
    }

    @Override
    public String voice()
    {
        return "Ooooyyyy-ooooyyyyyy";
    }

    @Override
    public boolean jump(float height)
    {
        return jump_limit >= height;
    }

    @Override
    public float getJumpLimit()
    {
        return jump_limit;
    }
}
